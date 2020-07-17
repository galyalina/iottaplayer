package com.chuppa.iotta.tempapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chuppa.iotta.tempapp.R
import com.chuppa.iotta.tempapp.data.network.model.User
import kotlinx.android.synthetic.main.fragment_users.*

class UsersListFragment : Fragment(R.layout.fragment_users), UserListAdapter.ClickListener {

    private val viewModel: UsersViewModel by viewModel()

    private val adapter: UserListAdapter by lazy { UserListAdapter(listener = this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
    }

    private fun initView() {
        val linearLayoutManager = LinearLayoutManager(context)
        usersList.layoutManager = linearLayoutManager
        usersList.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        viewModel.users.observe(viewLifecycleOwner, Observer { users ->
            adapter.setUsers(users)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onUserClick(user: User) {
        // Timber.d("")
    }
}
