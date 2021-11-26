
import axios from "axios";
import React, {useState, useEffect} from "react";
import {TextField} from '@material-ui/core'
const User = () =>{
    const [userProfiles,setUserProfiles] = useState([]);
  
    const fetchUserProfiles = () =>{
      axios.get("http://localhost:8080/api/v1/user").then(res=> {
        console.log(res);
        setUserProfiles(res.data);
      });
    };
  
    useEffect(()=>{
      fetchUserProfiles();
    },[]);
    
    //use for arrays
    return userProfiles.map((user,indx)=>{ //use for arrays
      return (
        <div key = {indx}>
          <h1>{user.username}</h1>
        </div>
      )
    })
    ////use for single object
    // return (
    //   <div >
    //     <h1>{userProfiles.username}</h1>
    //   </div>
    // )
    //return <h1>Hello</h1>
  };
  export default User;