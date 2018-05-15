package com.yllt.exception;

import com.yllt.response.Response;

public class ParamException extends Throwable {
	private Response response = null;

    public ParamException(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }
}
