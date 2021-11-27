import {TextField} from '@material-ui/core'
import Axios from "axios";
import React, {useState, useEffect} from "react";

const ReviewTextArea = ()=>{
    const url = "http://localhost:8080/api/v1/user/upload"
    //data object declared
    const [data,setData] = useState({
        username: "",
        password:""
    })

    //when called, send a post request to send data to backend
    function submit(e){
        e.preventDefault();
        Axios.post(url,data).then(res=>{
            console.log(res.data)
        }).catch(err=>{
            console.log(err);
        })
    }
    //when called, log out data sent
    function handle(e){
        const newdata ={...data}
        newdata[e.target.id] = e.target.value
        setData(newdata)
        console.log(newdata)
    }
    
    return(
        <form onSubmit={(e)=>submit(e)} >
            <TextField input onChangeCapture={(e)=>handle(e)} id="username" value={data.username} label ="Enter Username"/>
            <TextField input onChangeCapture={(e)=>handle(e)} id="password" value={data.password} label ="Enter Password"/>
            <button>submit</button>
        </form>
        
    );

}
export default ReviewTextArea;