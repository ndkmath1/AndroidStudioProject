//package com.example.android.phonecalltest;
//
//import android.os.Bundle;
//import android.support.design.widget.TabLayout;
//import android.support.v4.content.ContextCompat;
//import android.support.v4.view.ViewPager;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//
//public class CallKeypadActivity extends AppCompatActivity {
//
//    //Declaring All The Variables Needed
//
//    private Toolbar toolbar;
//    private TabLayout tabLayout;
//    private ViewPager viewPager;
//    private ViewPagerAdapter viewPagerAdapter;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_call_keypad);
//
//        /*
//        Assigning view variables to thier respective view in xml
//        by findViewByID method
//         */
//
////        toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        tabLayout = (TabLayout) findViewById(R.id.tabs);
//        viewPager = (ViewPager) findViewById(R.id.viewpager);
//
//        /*
//        Creating Adapter and setting that adapter to the viewPager
//        setSupportActionBar method takes the toolbar and sets it as
//        the default action bar thus making the toolbar work like a normal
//        action bar.
//         */
//        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
//        viewPager.setAdapter(viewPagerAdapter);
//        setSupportActionBar(toolbar);
//
//        /*
//        TabLayout.newTab() method creates a tab view, Now a Tab view is not the view
//        which is below the tabs, its the tab itself.
//         */
//
//        final TabLayout.Tab home = tabLayout.newTab();
//        final TabLayout.Tab inbox = tabLayout.newTab();
//        final TabLayout.Tab star = tabLayout.newTab();
//
//        /*
//        Setting Title text for our tabs respectively
//         */
//
////        home.setText("Home");
////        inbox.setText("Inbox");
////        star.setText("Star");
//
//        home.setIcon(R.drawable.icon_home_press);
//        inbox.setIcon(R.drawable.icon_event);
//        star.setIcon(R.drawable.icon_personal);
//
//        /*
//        Adding the tab view to our tablayout at appropriate positions
//        As I want home at first position I am passing home and 0 as argument to
//        the tablayout and like wise for other tabs as well
//         */
//        tabLayout.addTab(home, 0);
//        tabLayout.addTab(inbox, 1);
//        tabLayout.addTab(star, 2);
//
//        /*
//        TabTextColor sets the color for the title of the tabs, passing a ColorStateList here makes
//        tab change colors in different situations such as selected, active, inactive etc
//
//        TabIndicatorColor sets the color for the indiactor below the tabs
//         */
//
//        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
//        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));
//
//        /*
//        Adding a onPageChangeListener to the viewPager
//        1st we add the PageChangeListener and pass a TabLayoutPageChangeListener so that Tabs Selection
//        changes when a viewpager page changes.
//         */
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//
//    }
//
////    @Override
////    public boolean onCreateOptionsMenu(Menu menu) {
////        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.menu_main, menu);
////        return true;
////    }
////
////    @Override
////    public boolean onOptionsItemSelected(MenuItem item) {
////        // Handle action bar item clicks here. The action bar will
////        // automatically handle clicks on the Home/Up button, so long
////        // as you specify a parent activity in AndroidManifest.xml.
////        int id = item.getItemId();
////
////        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_settings) {
////            return true;
////        }
////
////        return super.onOptionsItemSelected(item);
////    }
//}
package com.example.android.phonecalltest;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CallKeypadActivity extends AppCompatActivity {

    //Declaring All The Variables Needed

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_keypad);

        /*
        Assigning view variables to thier respective view in xml
        by findViewByID method
         */

//        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        /*
        Creating Adapter and setting that adapter to the viewPager
        setSupportActionBar method takes the toolbar and sets it as
        the default action bar thus making the toolbar work like a normal
        action bar.
         */
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        setSupportActionBar(toolbar);

        /*
        TabLayout.newTab() method creates a tab view, Now a Tab view is not the view
        which is below the tabs, its the tab itself.
         */

        final TabLayout.Tab home = tabLayout.newTab();
        final TabLayout.Tab inbox = tabLayout.newTab();
        final TabLayout.Tab star = tabLayout.newTab();
        final TabLayout.Tab upload = tabLayout.newTab();

        //Setting Icons to our respective tabs

        home.setIcon(R.drawable.icon_home_press);
        inbox.setIcon(R.drawable.icon_event);
        star.setIcon(R.drawable.icon_personal);
        upload.setIcon(R.drawable.icon_upload);

        /*
        Adding the tab view to our tablayout at appropriate positions
        As I want home at first position I am passing home and 0 as argument to
        the tablayout and like wise for other tabs as well
         */
//        tabLayout.addTab(home, 0);
//        tabLayout.addTab(inbox, 1);
//        tabLayout.addTab(star, 2);

        View homeView = getLayoutInflater().inflate(R.layout.custom_view,null);
        ImageView iconHome = (ImageView) homeView.findViewById(R.id.imageView);
        TextView textView = (TextView) homeView.findViewById(R.id.textView);
        iconHome.setImageResource(R.drawable.icon_home_press);
        textView.setText("Home");

        View inboxView = getLayoutInflater().inflate(R.layout.custom_view,null);
        ImageView iconIn = (ImageView) inboxView.findViewById(R.id.imageView);
        TextView textViewIn = (TextView) inboxView.findViewById(R.id.textView);
        iconIn.setImageResource(R.drawable.icon_event);
        textViewIn.setText("Inbox");

        View starView = getLayoutInflater().inflate(R.layout.custom_view,null);
        ImageView iconStar = (ImageView) starView.findViewById(R.id.imageView);
        TextView textViewStar = (TextView) starView.findViewById(R.id.textView);
        iconStar.setImageResource(R.drawable.icon_personal);
        textViewStar.setText("Star");

        View uploadView = getLayoutInflater().inflate(R.layout.custom_view, null);
        ImageView iconUpload = (ImageView) uploadView.findViewById(R.id.imageView);
        TextView textViewUpload = (TextView) uploadView.findViewById(R.id.textView);
        iconUpload.setImageResource(R.drawable.icon_upload);
        textViewUpload.setText("Upload");

        home.setCustomView(homeView);
        inbox.setCustomView(inboxView);
        star.setCustomView(starView);
        upload.setCustomView(uploadView);

        tabLayout.addTab(home, 0);
        tabLayout.addTab(inbox, 1);
        tabLayout.addTab(star, 2);
        tabLayout.addTab(upload, 3);

        /*
        TabTextColor sets the color for the title of the tabs, passing a ColorStateList here makes
        tab change colors in different situations such as selected, active, inactive etc

        TabIndicatorColor sets the color for the indiactor below the tabs
         */

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicator));

        /*
        Adding a onPageChangeListener to the viewPager
        1st we add the PageChangeListener and pass a TabLayoutPageChangeListener so that Tabs Selection
        changes when a viewpager page changes.

        2nd We add the onPageChangeListener to change the icon when the page changes in the view Pager
         */

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        /*
                        setting Home as White and rest grey
                        and like wise for all other positions
                         */
                        home.setIcon(R.drawable.icon_home_press);
                        inbox.setIcon(R.drawable.icon_event);
                        star.setIcon(R.drawable.icon_personal);
                        upload.setIcon(R.drawable.icon_upload);
                        break;
                    case 1:
                        home.setIcon(R.drawable.icon_home);
                        inbox.setIcon(R.drawable.icon_event_press);
                        star.setIcon(R.drawable.icon_personal);
                        upload.setIcon(R.drawable.icon_upload);
                        break;
                    case 2:
                        home.setIcon(R.drawable.icon_home);
                        inbox.setIcon(R.drawable.icon_event);
                        star.setIcon(R.drawable.icon_personal_press);
                        upload.setIcon(R.drawable.icon_upload);
                        break;
                    case 3:
                        home.setIcon(R.drawable.icon_home);
                        inbox.setIcon(R.drawable.icon_event);
                        star.setIcon(R.drawable.icon_personal);
                        upload.setIcon(R.drawable.icon_upload_press);

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}