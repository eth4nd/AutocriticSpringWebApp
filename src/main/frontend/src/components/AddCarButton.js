import React from 'react'
import { Link } from 'react-router-dom'
import '../styles/AddCar.css'

function AddCarButton(){
    return(
    <div>
        <button>
            <Link to={`/addCar/`}>ADD CAR</Link>
        </button>
    </div>
    )
    

}

export default AddCarButton