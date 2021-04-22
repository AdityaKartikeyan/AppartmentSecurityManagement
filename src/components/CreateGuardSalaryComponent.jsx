import React, { Component } from 'react';
import GuardSalaryService from '../services/GuardSalaryService';


let today = new Date();
class CreateGuardSalaryComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            name: '',
            userId: '',
            amount: '',
            status: '',
            date: ''
            
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeuserIDHandler = this.changeuserIDHandler.bind(this);
        this.changeamountHandler = this.changeamountHandler.bind(this);
        this.changestatusHandler = this.changestatusHandler.bind(this);
        this.changedateHandler = this.changedateHandler.bind(this);

        this.saveGuardSalary = this.saveGuardSalary.bind(this);
    }
    saveGuardSalary = (e) => {
        e.preventDefault();
        let guardSalary = {name: this.state.name, userId: this.state.userId, amount: this.state.amount, status: this.state.status, date:today };
        console.log('GuardSalary =>' + JSON.stringify(guardSalary));

        GuardSalaryService.createGuardSalary(guardSalary).then(res =>{
            this.props.history.push('/GuardSalary');
        })
    }

    changeNameHandler = (event) => {
        this.setState ({name: event.target.value});    
    }
    changeuserIDHandler = (event) => {
        this.setState ({userId: event.target.value});    
    }
    changeamountHandler = (event) => {
        this.setState ({amount: event.target.value});    
    }
    changestatusHandler = (event) => {
        this.setState ({status: event.target.value});    
    }
    changedateHandler = (event) => {
        this.setState ({today: event.target.value});    
    }

    cancel(){
        this.props.history.push('/GuardSalary');

    }
    render() {
        return (
            <div>
                <div className = "container">
                    <div className = "row">
                         <div className = "card col-md-6 offset-md-3 offset-md-3">
                             <h3 className ="text-center">Add Guard Details </h3>
                             <div className = "card-body">
                                 <form>
                                     <div className = "form-group">
                                         <label>Name:</label>
                                         <input placeholder = "Name" name = "name" className = "form-control"
                                            value ={this.state.name} onChange={this.changeNameHandler}/>
                                     </div>
                                     <div className = "form-group">
                                         <label>User ID:</label>
                                         <input placeholder = "User ID" name = "userId" className = "form-control"
                                            value ={this.state.userId} onChange={this.changeuserIDHandler}/>
                                     </div>
                                     <div className = "form-group">
                                         <label>Amount:</label>
                                         <input placeholder = "amount" name = "amount" className = "form-control"
                                            value ={this.state.amount} onChange={this.changeamountHandler}/>
                                     </div>
                                     <div className = "form-group">
                                         <label>Status:</label>
                                         <input placeholder = "status" name = "status" className = "form-control"
                                            value ={this.state.status} onChange={this.changestatusHandler}/>
                                     </div>
                                     <div className = "form-group">
                                         <label>Date:</label>
                                         <input placeholder = "date" name = "date" className = "form-control"
                                            value ={today} onChange={this.changedateHandler}/>
                                     </div>
                                     <button className= "btn btn-success" onClick={this.saveGuardSalary}>Save</button>
                                     <button className= "btn btn-danger" onClick={this.cancel.bind(this)} style={{marginleft: "10px"}}>Cancel</button>
                                 </form>
                             </div>
                         </div>
                    </div>
                </div>
            </div>
        )
    }
}

export default CreateGuardSalaryComponent;