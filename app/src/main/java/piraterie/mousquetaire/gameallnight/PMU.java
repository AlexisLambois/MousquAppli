package piraterie.mousquetaire.gameallnight;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class PMU extends Fragment {

    private TableLayout mTableLayout;
    ProgressDialog mProgressBar;


    public static PMU newInstance() {
        // getActivity().getActionBar().setTitle("YOUR TITLE");
        return (new PMU());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // setup the table
        mTableLayout = (TableLayout) getView().findViewById(R.id.tableInvoices);

        mTableLayout.setStretchAllColumns(true);
        return inflater.inflate(R.layout.fragment_pmu, container, false);
    }

    public void startLoadData() {
        int leftRowMargin = 0;
        int topRowMargin = 0;
        int rightRowMargin = 0;
        int bottomRowMargin = 0;
        int textSize = 0, smallTextSize = 0, mediumTextSize = 0;

        textSize = (int) getResources().getDimension(R.dimen.font_size_verysmall);
        smallTextSize = (int) getResources().getDimension(R.dimen.font_size_small);
        mediumTextSize = (int) getResources().getDimension(R.dimen.font_size_medium);

        TextView textSpacer = null;

        mTableLayout.removeAllViews();

        textSpacer = new TextView(getContext());
        textSpacer.setText("");

        final TextView tv = new TextView(getContext());
        tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
        tv.setGravity(Gravity.LEFT);
        tv.setPadding(5, 15, 0, 15);
        tv.setText("Inv.#");
        tv.setBackgroundColor(Color.parseColor("#f0f0f0"));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);

        final TextView tv2 = new TextView(getContext());
        tv2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tv2.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
        tv2.setGravity(Gravity.LEFT);
        tv2.setPadding(5, 15, 0, 15);
        tv2.setText("Date");
        tv2.setBackgroundColor(Color.parseColor("#f7f7f7"));

        final LinearLayout layCustomer = new LinearLayout(getContext());
        layCustomer.setOrientation(LinearLayout.VERTICAL);
        layCustomer.setPadding(0, 10, 0, 10);
        layCustomer.setBackgroundColor(Color.parseColor("#f8f8f8"));

        final TextView tv3 = new TextView(getContext());
        tv3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
        tv3.setPadding(5, 5, 0, 5);
        tv3.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
        tv3.setGravity(Gravity.TOP);
        tv3.setText("Customer");
        tv3.setBackgroundColor(Color.parseColor("#f0f0f0"));

        layCustomer.addView(tv3);

        final LinearLayout layAmounts = new LinearLayout(getContext());
        layAmounts.setOrientation(LinearLayout.VERTICAL);
        layAmounts.setGravity(Gravity.RIGHT);
        layAmounts.setPadding(0, 10, 0, 10);
        layAmounts.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));

        final TextView tv4 = new TextView(getContext());
        tv4.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.MATCH_PARENT));
        tv4.setPadding(5, 5, 1, 5);
        layAmounts.setBackgroundColor(Color.parseColor("#f7f7f7"));
        tv4.setGravity(Gravity.RIGHT);
        tv4.setText("Inv.Amount");
        tv4.setBackgroundColor(Color.parseColor("#f7f7f7"));
        tv4.setTextSize(TypedValue.COMPLEX_UNIT_PX, smallTextSize);
        layAmounts.addView(tv4);


        // add table row
        final TableRow tr = new TableRow(getContext());
        tr.setId(1);
        TableLayout.LayoutParams trParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT,TableLayout.LayoutParams.WRAP_CONTENT);
        trParams.setMargins(leftRowMargin, topRowMargin, rightRowMargin, bottomRowMargin);
        tr.setPadding(0, 0, 0, 0);
        tr.setLayoutParams(trParams);
        tr.addView(tv);
        tr.addView(tv2);
        tr.addView(layCustomer);
        tr.addView(layAmounts);

        mTableLayout.addView(tr, trParams);

    }

}