package com.example.a5alumno.ejercicio6_menu;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ActionMode.Callback{
    public static final int ACTIVITY_REQUEST_CODE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) this.findViewById(R.id.my_toolbar_second);
        this.setSupportActionBar(mToolbar);

        final Button cntxtBtn = (Button) findViewById(R.id.context_button);
        cntxtBtn.setOnClickListener(this);

        TextView hello_txtView = (TextView) this.findViewById(R.id.context_text);
       // this.registerForContextMenu(cntxtBtn);

        ImageView imgMenu = (ImageView) findViewById(R.id.img_1);
        this.registerForContextMenu(imgMenu);
        //registerForContextMenu(this.hello_txtView);

        /*PopupMenu mPopMenu = new PopupMenu(this, this.findViewById(R.id.context_button));
        MenuInflater mMenuinInflater_popup = mPopMenu.getMenuInflater();
        mMenuinInflater_popup.inflate(R.menu.menu_new,mPopMenu.getMenu());

        mPopMenu.setOnMenuItemClickListener(this);

        mPopMenu.show();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater = this.getMenuInflater();
        mMenuInflater.inflate(R.menu.menu_act2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ImageView imgLike = (ImageView) findViewById(R.id.img_like);
        ImageView imgDislike = (ImageView) findViewById(R.id.img_dislike);
        if(item.getItemId()==R.id.likeItem)
        {
            imgLike.setVisibility(View.VISIBLE);
            imgDislike.setVisibility(View.INVISIBLE);
            Log.e("TAG","LIKE options item selected");

            return true;}
        else if(item.getItemId()==R.id.dislikeItem) {
            Log.e("TAG","DISLIKE options item selected");
            imgLike.setVisibility(View.INVISIBLE);
            imgDislike.setVisibility(View.VISIBLE);
            return true;
        }
        else if(item.getItemId()==R.id.addItem){
            imgLike.setVisibility(View.INVISIBLE);
            imgDislike.setVisibility(View.INVISIBLE);
            return true;
        }
        else return super.onOptionsItemSelected(item);

    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mContMenuInflater = this.getMenuInflater();
        mContMenuInflater.inflate(R.menu.menu_add,menu);
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.context_button){
            this.startActivity(new Intent(this, second_activity.class));
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    /*@Override
    public boolean onMenuItemClick(MenuItem item) {
        ImageView imgLike = (ImageView) findViewById(R.id.img_like);
        ImageView imgDislike = (ImageView) findViewById(R.id.img_dislike);
        if(item.getItemId()==R.id.addOne)
        {
            imgLike.setVisibility(View.VISIBLE);
            imgDislike.setVisibility(View.INVISIBLE);
            Log.e("TAG","LIKE options item selected");

            return true;}
        else if(item.getItemId()==R.id.addAll) {
            Log.e("TAG","DISLIKE options item selected");
            imgLike.setVisibility(View.INVISIBLE);
            imgDislike.setVisibility(View.VISIBLE);
            return true;
        }
        else return false;

    }*/
}
