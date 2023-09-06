package com.basanta.usercrud.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.basanta.usercrud.Enum.ResponseStatus;
import com.basanta.usercrud.message.CustomMessageSource;
import com.basanta.usercrud.response.GlobalApiResponse;

public class BaseController {
	
		protected final ResponseStatus API_SUCCESS_STATUS = ResponseStatus.SUCCESS;
		protected final ResponseStatus API_ERROR_STATUS = ResponseStatus.FAIL;
		
		@Autowired
		protected CustomMessageSource customMessageSource;
		
		protected GlobalApiResponse successResponse(String message, Object data) {
			
			GlobalApiResponse apiResponse = new GlobalApiResponse();
			apiResponse.setStatus(API_SUCCESS_STATUS);
			apiResponse.setData(data);
			apiResponse.setMessage(message);
			return apiResponse;
		}
		
		protected GlobalApiResponse errorResponse(String message, Object data) {
			
			GlobalApiResponse apiResponse = new GlobalApiResponse();
			apiResponse.setStatus(API_ERROR_STATUS);
			apiResponse.setData(data);
			apiResponse.setMessage(message);
			return apiResponse;
		}

}
