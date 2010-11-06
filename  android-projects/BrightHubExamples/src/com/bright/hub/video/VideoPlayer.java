package com.bright.hub.video;

import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.bright.hub.R;

public class VideoPlayer extends Activity implements SurfaceHolder.Callback {

	private int mVideoWidth = 320;
	private int mVideoHeight = 480;
	private MediaPlayer mMediaPlayer;
	private SurfaceView mPreview;
	private SurfaceHolder holder;
	private String videoPath = "/sdcard/my_video.mp4";

	/**
	 * 
	 * Called when the activity is first created.
	 */
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.layout_video);
		iniElements();
	}

	private void iniElements() {

		mPreview = (SurfaceView) findViewById(R.id.screen_tutorial_video_surface);

		holder = mPreview.getHolder();
		holder.addCallback(this);
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		holder.setSizeFromLayout();
		holder.setFixedSize(mVideoWidth, mVideoHeight);
		iniPlayer();

	}

	private void iniPlayer() {
		mMediaPlayer = new MediaPlayer();
		Log.e("VideoPlayer","After create Media Player");	
		
		mMediaPlayer.setDisplay(holder);
		try {
			mMediaPlayer.setDataSource(videoPath);
			Log.e("VideoPlayer","After DataSource");	
			Log.e("VideoPlayer","Video Path "+videoPath);	
			mMediaPlayer.prepare();
			Log.e("VideoPlayer","After Prepare");	
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.e("VideoPlayer","Before Start");
		mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
		mMediaPlayer.start();
	}

	@Override
	protected void onPause() {
		super.onPause();
		releaseMediaPlayer();
		doCleanUp();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		releaseMediaPlayer();
		doCleanUp();
	}

	private void releaseMediaPlayer() {
		if (mMediaPlayer != null) {
			mMediaPlayer.release();
			mMediaPlayer = null;
		}
	}

	private void doCleanUp() {
		mVideoWidth = 0;
		mVideoHeight = 0;

	}

	@Override
	public void surfaceChanged(SurfaceHolder arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceCreated(SurfaceHolder arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder arg0) {
		// TODO Auto-generated method stub

	}

}
