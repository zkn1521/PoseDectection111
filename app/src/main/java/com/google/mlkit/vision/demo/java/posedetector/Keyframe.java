package com.google.mlkit.vision.demo.java.posedetector;

import com.google.mlkit.vision.pose.PoseLandmark;

import java.util.List;
import java.util.Date;

interface Pose {
    boolean isValidPose(List<PoseLandmark> landmarks);
}

class PointAngle implements Pose {
    private List<Integer> toTrack;
    private int angle;
    private int leniency;

    public PointAngle(List<Integer> _toTrack, int _angle, int _leniency) {
        toTrack = _toTrack;
        angle = _angle;
        leniency = _leniency;
    }

    @Override
    public boolean isValidPose(List<PoseLandmark> landmarks) {
        // TODO: Write the logic to determine if the current pose matches what the points describe
        return false;
    }
}

class PointPosition implements Pose {
    private List<Integer> target;
    private int toTrack;
    private int leniency;

    public PointPosition(List<Integer> _target, int _toTrack, int _leniency) {
        target = _target;
        toTrack = _toTrack;
        leniency = _leniency;
    }

    @Override
    public boolean isValidPose(List<PoseLandmark> landmarks) {
        // TODO: Write the logic to determine if the current pose matches what the points describe
        return false;
    }
}

public class Keyframe implements Pose {
    private List<Pose> points;
    private Date startTime;
    private int timeLimit;

    public Keyframe(List<Pose> _points, int _timeLimit)  {
        points = _points;
        timeLimit = _timeLimit;
        startTime = null;
    }

    @Override
    public boolean isValidPose(List<PoseLandmark> landmarks) {
        // TODO: Implement the logic to invoke every point's validator
        return false;
    }

    public boolean isWithinTime() {
        // TODO: Implement logic to determine if the timer has expired
        return false;
    }

    public void clearTimer() {
        startTime = null;
    }
}
