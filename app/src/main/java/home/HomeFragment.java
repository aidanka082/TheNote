package home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import adapter.TaskAdapter;
import model.TaskModel;
import com.example.thenote1.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    private TaskModel model;
    private FragmentHomeBinding binding;
    private TaskAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        intRecycler();
        setResalt();
        return binding.getRoot();
    }



    private void intRecycler() {
        adapter = new TaskAdapter();
        binding.recycler.setAdapter(adapter);
        adapter.addModel(new TaskModel("Жизненный цикл","OnCreate()"));
        adapter.addModel(new TaskModel("Жизненный цикл","OnStart"));
        adapter.addModel(new TaskModel("Жизненный цикл","On Pause"));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
   public void setResalt(){
        getParentFragmentManager().setFragmentResultListener("title",getViewLifecycleOwner(), (requestKey, result) -> {

            TaskModel model =(TaskModel) result.getSerializable("name");
            adapter.addModel(model);















































        });

   }
}