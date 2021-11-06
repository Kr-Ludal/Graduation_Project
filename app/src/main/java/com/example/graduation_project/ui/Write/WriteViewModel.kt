package com.example.graduation_project.ui.Write

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.graduation_project.data.Write.WriteRepository

class WriteViewModel(private val writeRepository: WriteRepository):ViewModel() {

    private val _writeFormState = MutableLiveData<WriteFormState>()
    val writeFromState :LiveData<WriteFormState> = _writeFormState

    fun postWriteData(title:String,content:String,languageType:Int){
        writeRepository.postWriteData(title,content,languageType){}
    }

    fun writeDataChanged(title : String, content:String){
        if(!isCheckDataValid(title)){
            //_writeFormState.value= WriteFormState(isTitleDataValid = true)
        }else if(!isCheckDataValid(content)){
            //_writeFormState.value= WriteFormState(isContentDataValid = true)
        }else{
            _writeFormState.value= WriteFormState(isBothDataValid = true)
        }


//        if(isCheckDataValid(title)){
//            _writeFormState.value= WriteFormState(isTitleDataValid = true)
//        }else if(isCheckDataValid(content)){
//            _writeFormState.value= WriteFormState(isContentDataValid = true)
//        }else if(isCheckDataValid(title)&&isCheckDataValid(content)){
//            _writeFormState.value= WriteFormState(isBothDataValid = true)
//        }
//
//        if(!isCheckDataValid(title)){
//            _writeFormState.value=WriteFormState(isTitleDataValid = false)
//        }else if(!isCheckDataValid(content)){
//            _writeFormState.value= WriteFormState(isContentDataValid = false)
//        }else if(!isCheckDataValid(title)&&!isCheckDataValid(content)){
//            _writeFormState.value= WriteFormState(isBothDataValid = false)
//        }
    }

    private fun isCheckDataValid(content : String): Boolean {
        return content.isNotBlank()
    }


}