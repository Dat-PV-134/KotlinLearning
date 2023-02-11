package com.example.review

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.review.db.Person
import com.example.review.db.PersonDao
import kotlinx.coroutines.launch

class PersonViewModel(private val dao: PersonDao): ViewModel() {
    val personList = dao.getAllPerson()

    fun insertPerson(person: Person) = viewModelScope.launch {
        dao.insertPerson(person)
    }

    fun updatePerson(person: Person) = viewModelScope.launch {
        dao.updatePerson(person)
    }

    fun deletePerson(person: Person) = viewModelScope.launch {
        dao.deletePerson(person)
    }
}