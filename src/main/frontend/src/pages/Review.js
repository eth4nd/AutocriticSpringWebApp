import React from 'react'
import { useParams } from "react-router-dom";
import { CarList } from "../helpers/CarList";
import ReviewTextArea from '../components/ReviewTextArea';
function Review() {
    // retrieves name parameter from Router and searches in CarList for car with matching name
    const { name } = useParams()
    const car = CarList.find(c => c.name === name)

    return (
        <div className='review'>
            <div className='headerContainer'>
                <p>You are at the Review page</p>
                <h1>A review menu will be here</h1>
                <ReviewTextArea/>
            </div>
            <div className='carContainer'>
                <div style={{backgroundImage:`url(${car.image})`}} className='carImage2'/>
                <h1>{car.name}</h1>
                <h1>${car.price.toLocaleString()}</h1>
            </div>
        </div>
    )
}

export default Review

