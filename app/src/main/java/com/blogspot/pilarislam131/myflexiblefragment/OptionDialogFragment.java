package com.blogspot.pilarislam131.myflexiblefragment;


import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener{
    private Button btnChoose, btnClose;
    private RadioGroup rgOption;
    private RadioButton rbsaf, rbMou, rbLvg,rbMoyes;
    private OnOptionDialogListener onOptionDialogListener2;

    public OptionDialogFragment(){

    }

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener2;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener2){
        this.onOptionDialogListener2 = onOptionDialogListener2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedIntanceState){
        View view = inflater.inflate(R.layout.fragment_option_dialog,container,false);
        btnChoose = (Button) view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);

        btnClose = (Button) view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);

        rgOption = (RadioGroup)view.findViewById(R.id.rg_option);
        rbsaf = (RadioButton)view.findViewById(R.id.rb_saf);
        rbLvg = (RadioButton) view.findViewById(R.id.rb_lvg);
        rbMou = (RadioButton) view.findViewById(R.id.rb_mou);
        rbMoyes = (RadioButton) view.findViewById(R.id.rb_moyes);
        return view;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_close:
                getDialog().cancel();
                break;
            case R.id.btn_choose:
                int radioButtonId = rgOption.getCheckedRadioButtonId();
                if (radioButtonId != -1){
                    String coach = null;
                    switch (radioButtonId){
                        case R.id.rb_saf:
                            coach = rbsaf.getText().toString().trim();
                            break;
                        case R.id.rb_mou:
                            coach = rbMou.getText().toString().trim();
                            break;
                        case R.id.rb_lvg:
                            coach = rbLvg.getText().toString().trim();
                            break;
                        case R.id.rb_moyes:
                            coach = rbMoyes.getText().toString().trim();
                            break;
                    }
                    getOnOptionDialogListener().onOptionChoosen(coach);
                    getDialog().cancel();
                }
                break;
        }
    }

    public interface OnOptionDialogListener{
        void onOptionChoosen(String Text);
    }
}