package learn.b.btest;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Bilal on 024, 24-February-18.
 */


public class UpFragment extends Fragment {

    Button btnMessage;
    MessageCom msgComm ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_up, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnMessage = (Button) view.findViewById(R.id.btnMessage);

        btnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //((MessageCom) getActivity()).sendMessage();
                msgComm.sendMessage();
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            msgComm= (MessageCom) context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement MessageCom ");
        }
    }
}
