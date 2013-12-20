package com.kurento.kmf.jsonrpcconnector.internal.client;

import java.io.IOException;

import com.google.gson.JsonElement;
import com.kurento.kmf.jsonrpcconnector.client.JsonRpcClient;
import com.kurento.kmf.jsonrpcconnector.internal.server.AbstractSession;

public class ClientSession extends AbstractSession {

	private JsonRpcClient client;

	public ClientSession(String sessionId, Object registerInfo,
			JsonRpcClient client) {
		super(sessionId, registerInfo);
		this.client = client;
	}

	@Override
	public void close() throws IOException {
		client.close();
	}

	@Override
	public <R> R sendRequest(String method, Class<R> resultClass)
			throws IOException {
		return client.sendRequest(method, resultClass);
	}

	@Override
	public <R> R sendRequest(String method, Object params, Class<R> resultClass)
			throws IOException {
		return client.sendRequest(method, params, resultClass);
	}

	@Override
	public JsonElement sendRequest(String method) throws IOException {
		return client.sendRequest(method);
	}

	@Override
	public JsonElement sendRequest(String method, Object params)
			throws IOException {
		return client.sendRequest(method, params);
	}

	@Override
	public void sendNotification(String method, Object params)
			throws IOException {
		client.sendNotification(method, params);
	}

	@Override
	public void sendNotification(String method) throws IOException {
		client.sendNotification(method);
	}

	@Override
	public void setReconnectionTimeout(long millis) {
	}

}