package com.basanta.usercrud.Enum;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

@JsonFormat(shape = JsonFormat.Shape.NUMBER)
public enum ResponseStatus {
	
	FAIL,
	SUCCESS;

}
