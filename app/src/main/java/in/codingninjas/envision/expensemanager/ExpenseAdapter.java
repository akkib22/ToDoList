package in.codingninjas.envision.expensemanager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class
ExpenseAdapter extends ArrayAdapter {

    ArrayList<Expense> items;
    LayoutInflater inflater;

    public ExpenseAdapter(@NonNull Context context, ArrayList<Expense> items) {
        super(context, 0,  items);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View output = inflater.inflate(R.layout.expense_row_layout,parent,false);
        TextView nameTextView = output.findViewById(R.id.expenseName);
        TextView amountTextView = output.findViewById(R.id.expenseAmount);
        Expense expense = items.get(position);
        nameTextView.setText(expense.getName());
        amountTextView.setText(expense.getAmount() + "Rs");
        return output;
    }
}
