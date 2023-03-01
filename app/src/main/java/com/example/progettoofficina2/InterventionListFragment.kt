package com.example.progettoofficina2

import android.os.Bundle
import android.text.method.TextKeyListener.clear
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.progettoofficina2.adapters.InterventionAdapter
import com.example.progettoofficina2.db.DbOfficina
import com.example.progettoofficina2.entities.Intervention
import com.example.progettoofficina2.services.InterventionDao
import java.util.Collections.addAll


class InterventionListFragment : Fragment() {

    private lateinit var interventionDao: InterventionDao
    private lateinit var interventionsLiveData: LiveData<List<Intervention>>
    private lateinit var interventionListView: ListView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_intervention_list, container, false)
        interventionListView = view.findViewById(R.id.listView)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = DbOfficina.getDatabase(requireContext())
        interventionDao = db.interventionDao()
        interventionsLiveData = interventionDao.getAll()

        interventionListView.adapter = InterventionAdapter(requireContext(), interventionsLiveData)

        interventionsLiveData.observe(viewLifecycleOwner, Observer { interventions ->
            (interventionListView.adapter as InterventionAdapter).run {
                clear()
                addAll(interventions)
                notifyDataSetChanged()
            }
        })
    }
}


