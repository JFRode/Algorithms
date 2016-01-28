package jfrode.webview;

import java.lang.reflect.Method;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {

	private WebView view;
	private boolean paused = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		String iframe = "https://github.com/JFRode";

		view = (WebView) findViewById(R.id.webView);
		view.setWebChromeClient(new WebChromeClient());

		WebSettings settings = view.getSettings();
		settings.setBuiltInZoomControls(true);
		settings.setJavaScriptEnabled(true);

		paused = true;
		resumeBrowser();
		view.loadUrl(iframe);
	}

	@Override
	protected void onPause() {
		pauseBrowser();
		super.onPause();
	}

	@Override
	protected void onResume() {
		resumeBrowser();
		super.onResume();
	}

	private void pauseBrowser() {
		if (!paused) {
			callHiddenWebViewMethod(view, "onPause");
			view.pauseTimers();
			paused = true;
		}
	}

	private void resumeBrowser() {
		if (paused) {
			// resume flash and javascript etc
			callHiddenWebViewMethod(view, "onResume");
			view.resumeTimers();
			paused = false;
		}
	}

	private void callHiddenWebViewMethod(final WebView wv, final String name) {
		try {
			final Method method = WebView.class.getMethod(name);
			method.invoke(view);
		} catch (final Exception e) {
			// Exception
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
