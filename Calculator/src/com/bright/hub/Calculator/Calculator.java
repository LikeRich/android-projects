package com.bright.hub.Calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Calculator extends Activity {
	private EditText input1;
	private EditText input2;
	private EditText solution;
	private TextView operator;
	private Calculator mContext;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;

		setContentView(R.layout.main);

		input1 = (EditText) findViewById(R.id.input1);
		input2 = (EditText) findViewById(R.id.input2);
		solution = (EditText) findViewById(R.id.solution);
		operator = (TextView) findViewById(R.id.operator);

		// We create an OnClick Event in each button.

		Button plusButton = (Button) findViewById(R.id.plusbutton);
		Button minusButton = (Button) findViewById(R.id.minusbutton);
		Button prodButton = (Button) findViewById(R.id.prodbutton);
		Button divButton = (Button) findViewById(R.id.divbutton);
		Button equalButton = (Button) findViewById(R.id.equalbutton);

		plusButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				operator.setText("+");

			}

		});

		minusButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				operator.setText("-");

			}

		});

		prodButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				operator.setText("*");

			}

		});

		divButton.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				operator.setText("/");

			}

		});

		equalButton.setOnClickListener(new OnClickListener() {

			private AlertDialog show;

			public void onClick(View arg0) {

				if ((input1.getText().length() == 0)
						|| (input1.getText().toString() == " ")
						|| (input2.getText().length() == 0)
						|| (input2.getText().toString() == " ")) {

					show = new AlertDialog.Builder(mContext).setTitle("Error")
							.setMessage("Some inputs are empty")
							.setPositiveButton("OK", null).show();

				} else if (operator.getText().equals("")) {

					show = new AlertDialog.Builder(mContext).setTitle("Error")
							.setMessage("Operator is null").setPositiveButton(
									"OK", null).show();

				} else if (operator.getText().equals("+")) {

					double result = new Double(input1.getText().toString())
							+ new Double(input2.getText().toString());

					solution.setText(Double.toString(result));

				} else if (operator.getText().equals("-")) {

					double result = new Double(input1.getText().toString())
							- new Double(input2.getText().toString());

					solution.setText(Double.toString(result));

				} else if (operator.getText().equals("*")) {

					double result = new Double(input1.getText().toString())
							* new Double(input2.getText().toString());

					solution.setText(Double.toString(result));

				} else if (operator.getText().equals("/")) {
					

					double result = new Double(input1.getText().toString())
							/ new Double(input2.getText().toString());

					solution.setText(Double.toString(result));

				}

			}

		});

	}

}
