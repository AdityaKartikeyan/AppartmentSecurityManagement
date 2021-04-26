import React, { Component } from 'react';
import FlatService from "../services/FlatService";

class ViewFlatComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            flatNo: this.props.match.params.flatNo,
            flat: {}
        }
    }
    
    componentDidMount(){
        FlatService.getFlatByflatNo(this.state.flatNo).then(res=>{
            this.setState({flat: res.data});
        })
    }
    render() {
        return (
            <div>
                <br></br>
                <div className = "card col-md-6 offset-md-3">
                    <h3 className = "text-center"> View Flat Details</h3>
                    <div className = "card-body">
                        <div className = "row">
                            <label> Flat Owner Name: </label>
                            <div> {this.state.flat.ownerName }</div>
                        </div>
                        <div className = "row">
                            <label> Flat No: </label>
                            <div> { this.state.flat.flatNo}</div>
                        </div>
                        <div className = "row">
                            <label> FLoor No: </label>
                            <div> { this.state.flat.floorNo }</div>
                        </div>
                        <div className = "row">
                            <label> Flat Type: </label>
                            <div> { this.state.flat.flatType }</div>
                        </div>
                    </div>

                </div>
            </div>
        )
    }
}

export default ViewFlatComponent;