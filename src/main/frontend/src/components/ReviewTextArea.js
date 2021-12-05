import {TextField} from '@material-ui/core'
import Axios from "axios";
import React, {useState, useEffect} from "react";
import { FaStar } from "react-icons/fa";

const ReviewTextArea = ()=>{
    const url = "http://localhost:8080/api/v1/review/upload"
    //data object declared
    const [data,setData] = useState({
        review: "",
        rating: 0
        
    })

    const [finalData, setFinal] = useState([]);

    const colors = {
        orange: "#FFBA5A",
        grey: "#a9a9a9"
        
    };

    const [currentValue, setCurrentValue] = useState(0);
    const [hoverValue, setHoverValue] = useState(undefined);
    const stars = Array(5).fill(0)
  
    const handleClick = value => {
      setCurrentValue(value)
      data.rating = value;
      console.log(data);
    }
  
    const handleMouseOver = newHoverValue => {
      setHoverValue(newHoverValue)
    };
  
    const handleMouseLeave = () => {
      setHoverValue(undefined)
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        Axios.post(url,data).then(res=>{
            console.log(res.data)
            alert("Review has been posted!");
        }).catch(err=>{
            alert("Error: Not logged in or backend application not running");
        })
        setFinal({...finalData,data});
        console.log(finalData)
    }


    //when called, send a post request to send data to backend
    function submit(e){
        Axios.post(url,data).then(res=>{
            console.log(res.data)
            
        }).catch(err=>{
            
        })
    }
    //when called, log out data sent
    function handle(e){
        const newdata ={...data}
        newdata[e.target.id] = e.target.value
        setData(newdata)
        console.log(newdata)
    }
    
    return (
        <form onSubmit={handleSubmit}>
        <div style={styles.container}  >
          <div style={styles.stars}>
            {stars.map((_, index) => {
              return (
                <FaStar
                  key={index}
                  size={24}
                  onClick={() => handleClick(index + 1)}
                  onMouseOver={() => handleMouseOver(index + 1)}
                  onMouseLeave={handleMouseLeave}
                  color={(hoverValue || currentValue) > index ? colors.orange : colors.grey}
                  style={{
                    marginRight: 10,
                    cursor: "pointer"
                  }
                }
                />
              )
            })}
          </div>
          <textarea
            placeholder="What's your opinion on this car?"
            style={styles.textarea}
            input onChangeCapture={(e)=>handle(e)} id="review" value={data.review}
          />
    
          <button
          >
            submit
          </button>
          
        </div>
        </form>
      );
    };
    
    
    const styles = {
        container: {
          display: "flex",
          flexDirection: "column",
          alignItems: "center"
        },
        stars: {
          display: "flex",
          flexDirection: "row",
        },
        textarea: {
          border: "1px solid #a9a9a9",
          borderRadius: 5,
          padding: 10,
          margin: "20px 0",
          minHeight: 100,
          width: 300
        },
    }


export default ReviewTextArea;