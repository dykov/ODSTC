package com.netcracker.tc.shared.action.interview;

import com.gwtplatform.dispatch.rpc.shared.NoResult;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import com.netcracker.tc.shared.model.interview.InterviewResultDTO;

public class EditHRInterviewResultAction extends UnsecuredActionImpl<NoResult> {

    private InterviewResultDTO interviewResultDTO;

    public EditHRInterviewResultAction(InterviewResultDTO interviewResultDTO) {
        this.interviewResultDTO = interviewResultDTO;
    }

    private EditHRInterviewResultAction(){
    }

    public InterviewResultDTO getInterviewResultDTO() {
        return interviewResultDTO;
    }
}