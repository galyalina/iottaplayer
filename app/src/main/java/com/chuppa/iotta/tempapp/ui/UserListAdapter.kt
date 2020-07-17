package com.chuppa.iotta.tempapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chuppa.iotta.tempapp.R
import com.chuppa.iotta.tempapp.data.network.model.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*
import java.util.ArrayList

class UserListAdapter(
    private val listener: ClickListener
) : RecyclerView.Adapter<UserListAdapter.UserViewHolder>() {

    private var users: MutableList<User> = ArrayList()

    fun setUsers(users: List<User>) {
        this.users = users.toMutableList()
    }

    fun updateCharacter(user: User) {
        val index: Int = users.indexOfFirst { it.id == user.id }
        users[index] = user
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = users[position]
        holder.setUser(user)
        holder.view.setOnClickListener { listener.onUserClick(user) }
    }

    override fun getItemCount(): Int {
        return users.size
    }

    interface ClickListener {

        fun onUserClick(user: User)

    }

    inner class UserViewHolder internal constructor(
        val view: View
    ) : RecyclerView.ViewHolder(view) {

        fun setUser(user: User) {
            Picasso.get()
                .load(user.imageUrl)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(view.image)

            view.name.text = user.url
        }
    }
}
