package miprimerapp.android.teaching.com.miprimeraapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import miprimerapp.android.teaching.com.miprimeraapp.fragments.GameDetailFragment;
import miprimerapp.android.teaching.com.miprimeraapp.model.GameModel;
import miprimerapp.android.teaching.com.miprimeraapp.presenters.GameDetailPresenter;
import miprimerapp.android.teaching.com.miprimeraapp.view.GameDetailView;

public class GameDetailActivity extends AppCompatActivity
        implements GameDetailView {

    private GameDetailPresenter presenter;
    private int currentPosition;
    private String currentGameWebSite;
    private MyPageAdapter myPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        android.support.v7.widget.Toolbar myToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
        ActionBar myActionBar = getSupportActionBar();
        myActionBar.setDisplayHomeAsUpEnabled(true);

        presenter = new GameDetailPresenter();

        currentPosition = getIntent().getIntExtra("position", 0);
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.startPresenting(this);
        final ViewPager myViewPager = findViewById(R.id.viewpager);
        myPageAdapter = new MyPageAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myPageAdapter);
        myViewPager.setCurrentItem(currentPosition);
        getSupportActionBar().setTitle(myPageAdapter.getPageTitle(currentPosition));
        myViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            getSupportActionBar().setTitle(myPageAdapter.getPageTitle(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    public void onGameLoaded(GameModel game) {
       }

       private class MyPageAdapter extends FragmentStatePagerAdapter{

           public MyPageAdapter(FragmentManager fm) {
               super(fm);
           }

           public CharSequence getPageTitle (int position){
               return presenter.getGames().get(position).getName();
           }

           @Override
           public Fragment getItem(int position) {
               int gameID = presenter.getGames().get(position).getId();
               return GameDetailFragment.newInstance(gameID);
           }

           @Override
           public int getCount() {
               return presenter.getGames().size();
           }
       }



}