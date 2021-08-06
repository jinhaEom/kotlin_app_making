package com.example.fileio

import java.io.*
import kotlin.io.path.createTempDirectory

class FileUtil {

    fun readTextFile(fullPath:String) : String { ///fullPath 파라미터로 파일의 경로를 전달받는 메서드를 생성
        val file = File(fullPath)
        if(!file.exists()) return "" //result 변수로 파일을 읽은 결괏값 리턴.

        val reader = FileReader(file)
        val buffer = BufferedReader(reader)
        var temp:String? = null
        var result = ""
        while(true){
            temp = buffer.readLine()
            if(temp == null) break
            else result += temp + "\n"
        }
        buffer.close()
        reader.close()
        return result
    }
    fun writeTextFile(directory:String,filename:String,content:String){
        //쓰기 파일은 총 3개 (1.파일을 생성할 디렉토리, 2.파일명, 3.작성할 내용) 의 파라미터값이 전달되어야 함.
        val dir =File(directory)
        if(!dir.exists()){
            dir.mkdirs()  //디렉토리가 존재하는지 검사하고 없으면 생성.
        }
        val writer = FileWriter(directory+"/"+filename)
        val buffer = BufferedWriter(writer)
        buffer.write(content)
        buffer.close()
    }

}
/*
* openFileInput을 사용해 읽기 코드 축약하기
* openFileInput과 몇개의 메서드들을 조합하면 짧은 코드로 텍스트파일 읽기 가능.
*
* var contents = ""
* context.openFileInput("파일 경로").bufferedReader().useLines { lines ->
*   contents = lines.joinToString("\n")
*  */

/*openFileInput으로 쓰기 코드 축약하기
* 파일명 후에 입력되는 Context.MODE_PRIVATE 대신 Context.MODE_APPEND를 사용하면 기존에
* 동일한 파일명이 있을 경우 기존 내용에 이어서 새로운 내용을 ㅓ장할수 있음.
*
* val contents = "Hello\nworld!"
* context.openFileOutput("파일명",Context.MODE_PRIVATE).use{ stream ->
*       stream.write(contents.toByteArray())
*  */
