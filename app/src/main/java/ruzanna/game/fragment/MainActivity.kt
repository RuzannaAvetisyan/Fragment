package ruzanna.game.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity()  {
    private val fragment1 = Fragment1()
    private val fragment2 = Fragment2()
    private var fragmentTemp: Fragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.add).setOnClickListener {
            when(fragmentTemp){
                null -> {
                    supportFragmentManager.beginTransaction()
                        .add(R.id.container, fragment1, "fragment1").commit()
                    fragmentTemp = fragment1
                }
            }
        }
        findViewById<Button>(R.id.replace).setOnClickListener {
            when(fragmentTemp){
                fragment1 ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment2, "fragment2").remove(fragment1).commit()
                    fragmentTemp = fragment2
                }
                fragment2 ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, fragment1, "fragment1").remove(fragment2).commit()
                    fragmentTemp = fragment1
                }
            }
        }
        findViewById<Button>(R.id.remove).setOnClickListener {
            fragmentTemp?.let { fTemp -> supportFragmentManager.beginTransaction().remove(fTemp).commit() }
            fragmentTemp = null
        }
    }
}

class Fragment1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}

class Fragment2 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.frag2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}


