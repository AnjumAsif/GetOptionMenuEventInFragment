package com.asif.showoptionmenuonfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.view.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment() {
    private val arrayListItem =
        arrayListOf("Test1", "Test2", "Test3", "Test4", "Test5", "Test6", "Test7", "Test8", "Test9")
    private val itemArrayList = HashMap<String, Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)


        for (index in arrayListItem.indices) {
            itemArrayList[arrayListItem[index]] = Item(
                arrayListItem[index], isAdd = false, isEdit = false,
                isDelete = false,
                isView = false
            )
        }
        view.recyclerView.setHasFixedSize(true)
        view.recyclerView.layoutManager = LinearLayoutManager(activity)
        view.recyclerView.adapter = ItemAdapter(
            mContext = activity as Context,
            itemArrayList = itemArrayList, itemLabel = arrayListItem, mListener = object : OnItemClick {
                override fun OnClickItemGet(item: HashMap<String,Item>) {
                    Log.e("Log", item.toString())
                }
            }
        )
        view.button.setOnClickListener {
            Log.e("LOG", "")
        }


        return view
    }


    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
//        val inflater: MenuInflater = activity.getSupportMenuInflater()
//        inflater!!.inflate(R.menu.menu, menu)
        menu!!.findItem(R.id.item1).isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //get item id to handle item clicks
        val id = item!!.itemId
        //handle item clicks
        if (id == R.id.item1) {
            //do your action here, im just showing toast
            Toast.makeText(activity, "item1", Toast.LENGTH_SHORT).show()
        }
        if (id == R.id.item2) {
            //do your action here, im just showing toast
            Toast.makeText(activity, "item2", Toast.LENGTH_SHORT).show()
        }
        if (id == R.id.item3) {
            //do your action here, im just showing toast
            Toast.makeText(activity, "item3", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }
}
