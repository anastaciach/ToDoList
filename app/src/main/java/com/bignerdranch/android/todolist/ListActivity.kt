import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.bignerdranch.android.todolist.FragmentSecond
import com.bignerdranch.android.todolist.ListFragment
import com.sample.todolist.R
import java.util.UUID

class ListActivity : AppCompatActivity(), ListFragment.Callbacks, FragmentSecond.Callbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment == null) {
            val fragment = ListFragment.newInstance()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit()
        }
    }
    override fun onListSelected(listId: UUID)
    {
        val fragment = FragmentSecond.newInstance(listId)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
    override fun setToolbarTitle(title: String){
        supportActionBar?.title = title
    }

}