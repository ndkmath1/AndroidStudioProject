package com.example.android.phonecalltest;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by khanh on 13/11/2016.
 */
public class HomeFragment extends Fragment {

    View mRootView;
    EditText txtPhoneNumber;
    ImageButton[] btn;
    ImageButton btnStar;
    ImageButton btnHash;
    ImageButton btnVoice;
    ImageButton btnCall;
    ImageButton btnDel;
    StringBuilder stringBuilder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mRootView = inflater.inflate(R.layout.tab_fragment_1, container, false);
        txtPhoneNumber = (EditText) mRootView.findViewById(R.id.txt_phone_number);

        btn = new ImageButton[10];

        btn[0] = (ImageButton) mRootView.findViewById(R.id.btn_0);
        btn[1] = (ImageButton) mRootView.findViewById(R.id.btn_1);
        btn[2] = (ImageButton) mRootView.findViewById(R.id.btn_2);
        btn[3] = (ImageButton) mRootView.findViewById(R.id.btn_3);
        btn[4] = (ImageButton) mRootView.findViewById(R.id.btn_4);
        btn[5] = (ImageButton) mRootView.findViewById(R.id.btn_5);
        btn[6] = (ImageButton) mRootView.findViewById(R.id.btn_6);
        btn[7] = (ImageButton) mRootView.findViewById(R.id.btn_7);
        btn[8] = (ImageButton) mRootView.findViewById(R.id.btn_8);
        btn[9] = (ImageButton) mRootView.findViewById(R.id.btn_9);
        btnStar = (ImageButton) mRootView.findViewById(R.id.btn_star);
        btnHash = (ImageButton) mRootView.findViewById(R.id.btn_hash);
        stringBuilder = new StringBuilder();

        for (int i = 0; i < 10; ++i) {
            btn[i].setOnClickListener(new ImageButtonListener(stringBuilder, String.valueOf(i), txtPhoneNumber));
        }
        btnStar.setOnClickListener(new ImageButtonListener(stringBuilder, "*", txtPhoneNumber));
        btnHash.setOnClickListener(new ImageButtonListener(stringBuilder, "#", txtPhoneNumber));

        btnDel = (ImageButton) mRootView.findViewById(R.id.btn_del);
        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtPhoneNumber.hasFocus()) {
                    int position = txtPhoneNumber.getSelectionEnd();
                    if (stringBuilder.length() > 0) {
                        txtPhoneNumber.setCursorVisible(true);
                        if (position > 0) {
                            stringBuilder.deleteCharAt(position - 1);
                            txtPhoneNumber.setText(stringBuilder);
                            txtPhoneNumber.setSelection(position - 1);
                        }
                    }
                    if (stringBuilder.length() == 0) {
                        txtPhoneNumber.setCursorVisible(false);
                    }
                } else {
                    int len = stringBuilder.length();
                    if (len > 0) {
                        stringBuilder.deleteCharAt(len - 1);
                        txtPhoneNumber.setText(stringBuilder);
                    }
                }


//                if (txtPhoneNumber.hasFocus()) {
//                    int positionEnd = txtPhoneNumber.getSelectionEnd();
//                    if (positionEnd >= 1) {
//                        stringBuilder.replace(positionEnd - 1, positionEnd, "");
//                        txtPhoneNumber.setText(stringBuilder);
//                        txtPhoneNumber.setSelection(positionEnd - 1);
//                        if (stringBuilder.length() == 0) {
//                            txtPhoneNumber.setFocusable(false);
//                        }
//                    }
//                }
            }
        });



        if (Build.VERSION.SDK_INT >= 11) {
            txtPhoneNumber.setRawInputType(InputType.TYPE_CLASS_TEXT);
            txtPhoneNumber.setTextIsSelectable(true);
        } else {
            txtPhoneNumber.setRawInputType(InputType.TYPE_NULL);
            txtPhoneNumber.setFocusable(true);
        }

        txtPhoneNumber.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (stringBuilder.length() == 0 || !b) {
                    txtPhoneNumber.setCursorVisible(false);
                } else {
                    txtPhoneNumber.setCursorVisible(true);
                }
            }
        });



        return mRootView;
    }

    private class ImageButtonListener implements View.OnClickListener {

        private StringBuilder stringBuilder;
        private String value;
        private EditText txtPhoneNumber;

        public ImageButtonListener(StringBuilder stringBuilder, String value, EditText txtPhoneNumber) {
            this.stringBuilder = stringBuilder;
            this.value = value;
            this.txtPhoneNumber = txtPhoneNumber;
        }

        @Override
        public void onClick(View view) {
            int position = txtPhoneNumber.getSelectionStart();
//            stringBuilder.append(value);
            stringBuilder.insert(position, value);
            txtPhoneNumber.setText(stringBuilder);
            if (txtPhoneNumber.hasFocus()) {
                txtPhoneNumber.setSelection(position + 1);
            }
        }
    }

}
