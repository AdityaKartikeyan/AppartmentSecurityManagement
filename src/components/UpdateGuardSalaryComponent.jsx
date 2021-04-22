import React, { Component } from 'react';
import GuardSalaryService from '../services/GuardSalaryService';
let today = new Date();

class UpdateGuardSalaryComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            name: '',
            userId: this.props.match.params.userId,
            id: '',
            amount: '',
            status: '',
          
            
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeamountHandler = this.changeamountHandler.bind(this);
        this.changestatusHandler = this.changestatusHandler.bind(this);
       

        this.updateGuardSalary = this.updateGuardSalary.bind(this);
    }

    componentDidMount(){
        GuardSalaryService.getGuardSalayById(this.state.userId).then( (res) => {
            let guardSalary = res.data;
            this.setState({name: guardSalary.name, 
                id: guardSalary.id, 
                amount: guardSalary.amount,
                status: guardSalary.status,
                
            });

        });
    }

    updateGuardSalary = (e) => {
        e.preventDefault();
        let guardSalary = {name: this.state.name, id: this.state.id, amount: this.state.amount, status: this.state.status, date:today };
        console.log('GuardSalary =>' + JSON.stringify(guardSalary));

        GuardSalaryService.updateGuardSalary(guardSalary, this.state.userId).then(
            (res) => {
              this.props.history.push("");
            }
          );

       
    }

    changeNameHandler = (event) => {
        this.setState ({name: event.target.value});    
    }
    changeIdHandler = (event) => {
        this.setState ({id: event.target.value});    
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
                             <h3 className ="text-center">Update Guard Details </h3>
                             <div className = "card-body">
                                 <form>
                                     <div className = "form-group">
                                         <label>Name:</label>
                                         <input placeholder = "Name" name = "name" className = "form-control"
                                            value ={this.state.name} onChange={this.changeNameHandler}/>
                                     </div>
                                     <div className = "form-group">
                                         <label>Id:</label>
                                         <input placeholder = "id" name = "id" className = "form-control"
                                            value ={this.state.id} onChange={this.changeIdHandler}/>
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
                                     <button className= "btn btn-success" onClick={this.updateGuardSalary}>Save</button>
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
export default UpdateGuardSalaryComponent;