package com.google.mlkit.vision.demo.java.posedetector;

import java.util.List;

import com.google.mlkit.vision.pose.PoseLandmark;

public class PoseOracle {
    private List<Keyframe> kfs;
    int currentKeyframe;
    boolean status;

    public PoseOracle(List<Keyframe> _kfs) {
        kfs = _kfs;
        currentKeyframe = 0;
        status = false;
    }

    public boolean validatePose(List<PoseLandmark> landmarks) {
        // TODO: Write the logic here to connect the lower-level functions
        Keyframe kf = kfs.get(currentKeyframe);

        boolean validPose = kf.isValidPose(landmarks);
        boolean withinTime = kf.isWithinTime();
        if (!withinTime) {
            // reset the state
            for (int i = 0; i < currentKeyframe; i++) {
                kfs.get(i).clearTimer();
            }
            currentKeyframe = 0;
        } else if (!validPose) {
            // continue
        } else {
            // move to the next keyframe
            // or terminate if traversed all keyframes
            if (currentKeyframe == kfs.size() - 1) {
                status = true;
            } else {
                currentKeyframe++;
            }
        }
        return status;
    }
}