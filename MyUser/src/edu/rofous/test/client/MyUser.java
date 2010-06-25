package edu.rofous.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyUser implements EntryPoint {

	private final LoginServiceAsync service = GWT.create(LoginService.class);
	
	public void onModuleLoad() {

		GWT.log("Message :"+GWT.getHostPageBaseURL());
service.login(GWT.getHostPageBaseURL(), new AsyncCallback<LoginInfo>() {

	@Override
	public void onFailure(Throwable caught) {
		Window.alert("Result" );
		
	}

	@Override
	public void onSuccess(LoginInfo result) {
		result.getLoginUrl();
		
	}
});		
	}
}
