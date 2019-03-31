package com.alejandrorios.condorsports.common;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog;

import com.alejandrorios.condorsports.R;

public class ConfirmationDialog implements DialogInterface {

	private final Context context;
	private AlertDialog dialog;

	public ConfirmationDialog(final Context context) {
		this.context = context;
	}

	@Override
	public void cancel() {
		if (dialog != null) {
			dialog.cancel();
		}
	}

	@Override
	public void dismiss() {
		if (dialog != null) {
			dialog.dismiss();
		}
	}

	public void showSimple(final int messageId, final boolean isCancelable) {
		final Resources resources = context.getResources();
		final AlertDialog.Builder builder = new AlertDialog.Builder(context);
		final String message = resources.getString(messageId);
		final String confirmButton = resources.getString(R.string.button_ok);

		builder.setMessage(message)
				.setCancelable(isCancelable)
				.setPositiveButton(confirmButton, new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
					}
				});
		dialog = builder.show();
	}
}
