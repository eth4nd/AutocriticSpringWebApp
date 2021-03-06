//import React from 'react'
import '../styles/SignUp.css'
import {TextField} from '@material-ui/core'
import Axios from "axios";
import React, {useState, useEffect} from "react";
import axios from "axios";
import { Redirect } from 'react-router-dom';
const SignUp = ()=>{
    const [condition,setCondition] = useState([]);
  
    const fetchUserProfiles = () =>{
      axios.get("http://localhost:8080/api/v1/service").then(res=> {
        console.log(res);
        setCondition(res.data);
      });
    };
  
    useEffect(()=>{
      fetchUserProfiles();
    });

    console.log(condition);
    console.log("HELLO");

    const url = "http://localhost:8080/api/v1/user/signUp"
    const urlLogIn = "http://localhost:8080/api/v1/user/logIn"
    //data object declared
    const [data,setData] = useState({
        username: "",
        password:""
    })
    const [dataLogIn,setDataLogIn] = useState({
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
        alert("Sign up successful, please log in with these credientials");
    }
    function submitLogIn(d){
        //d.preventDefault();
        Axios.post(urlLogIn,dataLogIn).then(res=>{
            console.log(res.dataLogIn)
        }).catch(err=>{
            console.log(err);
        })
        if(!condition)
        {
            alert("wrong credientials, please create a new account or use correct credientials");
        }
        else
        {
            alert("login success: logged in as " + dataLogIn.username);
        }
    }
    //when called, log out data sent
    function handle(e){
        const newdata ={...data}
        newdata[e.target.id] = e.target.value
        setData(newdata)
        console.log(newdata)
    }
    function handleLogIn(d){
        const newdata ={...dataLogIn}
        newdata[d.target.id] = d.target.value
        setDataLogIn(newdata)
        console.log(newdata)
    }

    function loginFailed()
    {
        console.log("condition = " + condition);
        alert("Login Failed: Incorrect Credentials");
        
    }
    return (
        
        <div className='signup'>
            <div className='headerContainer'>
                <p>You are at the Sign Up page</p>
                <h1>Sign up to start reviewing</h1>
            </div>
            <div className='menuContainer'>
                <form className='signupMenu' onSubmit={(e)=>submit(e)}>
                    <p>Don't have an account? Sign up below.</p>
                    <label htmlFor='username'>Username</label>
                    <input type='text' id='username' value={data.username} input onChangeCapture={(e)=>handle(e)}/>
                    <label htmlFor='password'>Password</label>
                    <input type='password' id='password' value={data.password} input onChangeCapture={(e)=>handle(e)}/>
                    <input className='signupButton' type='submit' value='SIGN UP' />
                </form>
                <form className='loginMenu' action={condition?'/':'/signup'} onSubmit={(d)=>submitLogIn(d)}>
                    <p>Already have an account? Log in below.</p>
                    <label htmlFor='username'>Username</label>
                    <input type='text' id='username' value={dataLogIn.username} input onChangeCapture={(d)=>handleLogIn(d)}/>
                    <label htmlFor='password'>Password</label>
                    <input type='password' id='password' value={dataLogIn.password} input onChangeCapture={(d)=>handleLogIn(d)}/>
                    <input className='loginButton' type='submit' value='LOG IN' />
                </form>
            </div>
        </div>
    )

    return(
        <form onSubmit={(e)=>submit(e)} >
            <TextField input onChangeCapture={(e)=>handle(e)} id="username" value={data.username} label ="Enter Username"/>
            <TextField input onChangeCapture={(e)=>handle(e)} id="password" value={data.password} label ="Enter Password"/>
            <button>submit</button>
        </form>
        
    );

}
export default SignUp;

// function SignUp() {
//     return (
//         <div className='signup'>
//             <div className='headerContainer'>
//                 <p>You are at the Sign Up page</p>
//                 <h1>Sign up to start reviewing</h1>
//             </div>
//             <div className='menuContainer'>
//                 <form className='signupMenu' action='/'>
//                     <p>Don't have an account? Sign up below.</p>
//                     <label htmlFor='username'>Username</label>
//                     <input type='text' id='username' />
//                     <label htmlFor='password'>Password</label>
//                     <input type='text' id='password' />
//                     <input className='signupButton' type='submit' value='SIGN UP' />
//                 </form>
//                 <form className='loginMenu' action='/'>
//                     <p>Already have an account? Log in below.</p>
//                     <label htmlFor='username'>Username</label>
//                     <input type='text' id='username' />
//                     <label htmlFor='password'>Password</label>
//                     <input type='text' id='password' />
//                     <input className='loginButton' type='submit' value='LOG IN' />
//                 </form>
//             </div>
//         </div>
//     )
// }

// export default SignUp
