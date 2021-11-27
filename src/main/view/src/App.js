import logo from './logo.svg';
import './App.css';
import axios from "axios";
import React, {useState, useEffect} from "react";
import User from "./Components/Data/User.js"
import {TextField} from '@material-ui/core'
import ReviewTextArea from "./Components/Text/ReviewTextArea.js"
import UserTextArea from "./Components/Text/UserTextArea.js"

// const User = () =>{
//   const [userProfiles,setUserProfiles] = useState([]);

//   const fetchUserProfiles = () =>{
//     axios.get("http://localhost:8080/api/v1/user").then(res=> {
//       console.log(res);
//       setUserProfiles(res.data);
//     });
//   };

//   useEffect(()=>{
//     fetchUserProfiles();
//   },[]);
  
//   //use for arrays
//   return userProfiles.map((user,indx)=>{ //use for arrays
//     return (
//       <div key = {indx}>
//         <h1>{user.username}</h1>
//       </div>
//     )
//   })
//   ////use for single object
//   // return (
//   //   <div >
//   //     <h1>{userProfiles.username}</h1>
//   //   </div>
//   // )
//   //return <h1>Hello</h1>
// };


function App() {
  return (
    <div className="App">
      <TextField label="Enter Review" 
      color="secondary" 
      multiline 
      variant="outlined" />
     <User />
     <UserTextArea/>
    </div>
  );
}

export default App;
