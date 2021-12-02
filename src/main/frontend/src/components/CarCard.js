import React,{useState} from 'react'
import { Link } from 'react-router-dom'
import '../styles/CarCard.css'
import Axios from "axios";

function CarCard({ image, name, price }) {
    
    const url = "http://localhost:8080/api/v1/review/upload"
    //data object declared
    const [data,setData] = useState({
        review: "",
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

    return (
        <div className='carCard'>
            <div style={{backgroundImage:`url(${image})`}} className='carImage'/>
            <div>
                <h1>{name}</h1>
                <h2>MSRP: ${price.toLocaleString()}</h2>
                <button>
                    <Link to={`/review/${name}`}>WRITE A REVIEW</Link>
                </button>
            </div>
        </div>
    )
}

export default CarCard
