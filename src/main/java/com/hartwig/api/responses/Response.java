package com.hartwig.api.responses;

public class Response<T> {

	private T data;
	private String error;

	public Response(T data) {
		this.data = data;
	}

	public Response(String error) {
		this.error = error;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
