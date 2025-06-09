package com.vho.activ.service;

import com.vho.activ.models.Meeting;
import com.vho.activ.repo.MeetingRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MeetingService {

    private MeetingRepo meetingRepo;

    public MeetingService(MeetingRepo meetingRepo) {
        this.meetingRepo = meetingRepo;
    }

    public Meeting saveMeeting(Meeting meeting) {
        return meetingRepo.save(meeting);
    }
    public Meeting getMeetingById(Long meetingId) {
        return meetingRepo.findById(meetingId).get();
    }
    public List<Meeting> getAllMeetings() {
        return meetingRepo.findAll();
    }
}
