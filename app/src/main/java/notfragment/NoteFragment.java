package notfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thenote1.R;
import com.example.thenote1.databinding.FragmentNoteBinding;

import org.jetbrains.annotations.NotNull;

import model.TaskModel;

public class NoteFragment extends Fragment {
    private FragmentNoteBinding binding;

   TaskModel model;
   NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNoteBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnSave.setOnClickListener(v -> save() );

        }

    private void save() {
        binding.btnSave.setOnClickListener(v -> {
        String title2 = binding.etText.getText().toString();
        String desc2 =  binding.etLog.getText().toString();
        model = new TaskModel(title2, desc2);
        Bundle bundle = new Bundle();
        bundle.putSerializable("name",model);
        getParentFragmentManager().setFragmentResult("title",bundle);
        Log.e("TAG","save : " + model.getTitle() + model.getDesc());
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main);
        navController.navigateUp();
    });
  }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}