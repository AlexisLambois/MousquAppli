package piraterie.mousquetaire.gameallnight;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.NumberPicker;

public class PmuDialogFragment extends DialogFragment {

    private View rootView;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.fragment_pmu_dialog, null))
                // Add action buttons
                .setPositiveButton("Ajouter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText editText = (EditText) getDialog().findViewById(R.id.username);
                    }
                });
        return builder.create();
    }

    @Override
    public void onStart (){
        super.onStart();
        NumberPicker np = (NumberPicker) getDialog().findViewById(R.id.numberPicker1);
        np.setMinValue(0);
        np.setMaxValue(50);
        np.setWrapSelectorWheel(true);
    }
}
