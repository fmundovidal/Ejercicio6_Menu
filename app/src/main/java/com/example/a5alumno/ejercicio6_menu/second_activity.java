package com.example.a5alumno.ejercicio6_menu;

import android.media.Image;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class second_activity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener, PopupMenu.OnMenuItemClickListener, ActionMode.Callback//, android.view.ActionMode.Callback
{

    private ActionMode mActionmode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Toolbar mChildToolbar = (Toolbar) this.findViewById(R.id.my_toolbar_third);
        this.setSupportActionBar(mChildToolbar);

        ActionBar mActionBar = this.getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);

        final ImageView icon_ImgView = (ImageView) this.findViewById(R.id.img_2);
        icon_ImgView.setOnLongClickListener(this);

       /* PopupMenu mPopMenu = new PopupMenu(this, this.findViewById(R.id.context_button));
        MenuInflater mMenuinInflater_popup = mPopMenu.getMenuInflater();
        mMenuinInflater_popup.inflate(R.menu.menu_new,mPopMenu.getMenu());

        //mPopMenu.setOnMenuItemClickListener(this);

        mPopMenu.show();*/
    }


    @Override
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        MenuInflater mMenuInflater = actionMode.getMenuInflater();
        mMenuInflater.inflate(R.menu.menu_new,menu);
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode actionMode) {

    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        if(view.getId() == R.id.img_2){
            //this.mActionmode = this.startActionMode(this);
            this.mActionmode = this.startSupportActionMode(this);
            view.setSelected(true);
            return true;
        }
        else
            return false;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}
