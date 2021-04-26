import React, { Component } from 'react'
import VisitorService from '../services/VisitorService';


class ListAllVisitorsComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            visitors: [],
        };

        this.addVisitor = this.addVisitor.bind(this);
        this.editVisitor = this.editVisitor.bind(this);
        this.deleteVisitor = this.deleteVisitor.bind(this);
    }

    baseEntity(visitorId) {
        this.props.history.push(`/getByPk/${visitorId}`);
    }

    editVisitor(visitorId){
        this.props.history.push(`/updateVisitor/${visitorId}`);
    }

    componentDidMount(){
        VisitorService.getAllVisitors().then((res) => {
            this.setState({ visitors: res.data});
        });
    }

    addVisitor(){
        this.props.history.push('/addVisitor');
    }
    
    viewVisitor(visitorId){
        this.props.history.push(`/getById/${visitorId}`);
    }
    
    deleteVisitor(id){
        VisitorService.deleteVisitor(id).then( res => {
            this.setState({visitors: this.state.visitors.filter((visitors) => 
            visitors.id !== id),});
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Visitors' List</h2>
                    <div className = "row">
                        <button className="btn btn-primary" onClick={this.addVisitor}>Add Visitor</button>
                    </div>
                <br></br>
                <div className = "row">
                    <table className = "table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> Visitor ID</th>
                                <th> Visitor Name</th>
                                <th> Owner Name</th>
                                <th> Flat Number</th>
                                <th> Date </th>
                                <th> Arrival Time</th>
                                <th> Departure Time</th>
                                <th> Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.visitors.map(visitors => 
                                    <tr key = {visitors.visitorId}>
                                            <td> {visitors.visitorId} </td>
                                            <td> {visitors.name} </td>
                                            <td> {visitors.ownerName} </td>   
                                            <td> {visitors.flatNo} </td>
                                            <td> {visitors.date} </td>
                                            <td> {visitors.arrivalTime} </td>
                                            <td> {visitors.departureTime} </td>
                                            <td>
                                                <button onClick={ () => this.editVisitor(visitors.visitorId)} 
                                                    className="btn btn-info">Update </button>
                                                <button style={{marginLeft: "5px"}} onClick={ () => this.deleteVisitor(visitors.id)} 
                                                    className="btn btn-danger"> Delete </button>
                                                <button style={{marginLeft: "5px"}} onClick={ () => this.viewVisitor(visitors.visitorId)} 
                                                    className="btn btn-info"> View </button>
                                                <button style={{ marginLeft: "5px" }} onClick={() => this.baseEntity(visitors.visitorId)}
                                                    className="btn btn-info"> Audit</button>
                                            </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ListAllVisitorsComponent;