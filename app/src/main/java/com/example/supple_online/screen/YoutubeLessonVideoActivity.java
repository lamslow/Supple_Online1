package com.example.supple_online.screen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.supple_online.R;
import com.example.supple_online.helper.Config;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Stack;

public class YoutubeLessonVideoActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{

    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayerView youTubePlayer;
    String videoID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        Intent intent = getIntent();
        videoID = intent.getStringExtra("videoID");
        youTubePlayer = findViewById(R.id.youtube_player_view);
        youTubePlayer.initialize(Config.YOUTUBE_API_KEY, this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean b) {
        if (!b) {
//            youTubePlayer.cueVideo("XAxycuZPxQE");
            player.loadVideo(videoID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            getYoutubePlayerProvider().initialize(Config.YOUTUBE_API_KEY,this);
        }
    }

   protected YouTubePlayer.Provider getYoutubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_player_view);
    }

}