import React, { Component } from 'react';
import GuardSalaryService from '../services/GuardSalaryService';
const regExp1 = RegExp(/^[0-9]+$/);
const regExp2 = RegExp(/^[0-9]+$/);

const formValid = ({ isError, ...rest }) => {
    let valid = true;
  
    Object.values(isError).forEach((val) => {
      val.length > 0 && (valid = false);
    });
  
    Object.values(rest).forEach((val) => {
      val == null && (valid = false);
    });
  
    return valid;
  };

let today = new Date();


class UpdateGuardSalaryComponent extends Component {
    constructor(props){
        super(props)

        this.state = {
            createdBy:"",
            modifiedBy:"",
            name: '',
            userId: this.props.match.params.userId,
            id: '',
            amount: '',
            status: '',
            isError: {
                createdBy:"",
                modifiedBy:"",
                userId: "",
                name: "",
                amount: "",
                status: "",
              },
              disabled: true
          
            
        }
        this.changeCreatedByHandler = this.changeCreatedByHandler.bind(this);
        this.changeModifiedByHandler = this.changeModifiedByHandler.bind(this);
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeIdHandler = this.changeIdHandler.bind(this);
        this.changeamountHandler = this.changeamountHandler.bind(this);
        this.changestatusHandler = this.changestatusHandler.bind(this);
       

        this.updateGuardSalary = this.updateGuardSalary.bind(this);
    }

    componentDidMount(){
        GuardSalaryService.getGuardSalayById(this.state.userId).then( (res) => {
            let guardSalary = res.data;
            this.setState({
                createdBy: guardSalary.createdBy,
                modifiedBy: guardSalary.modifiedBy,
                name: guardSalary.name, 
                id: guardSalary.id, 
                amount: guardSalary.amount,
                status: guardSalary.status,
                
            });

        });
    }

    updateGuardSalary = (e) => {
        e.preventDefault();
        if(formValid(this.state))
        { 
        let guardSalary = {name: this.state.name,userId :this.state.userId, id: this.state.id, 
            amount: this.state.amount, status: this.state.status, date:today, createdBy: this.state.createdBy,
            modifiedBy: this.state.modifiedBy,};
        console.log('GuardSalary =>' + JSON.stringify(guardSalary));

        GuardSalaryService.updateGuardSalary(guardSalary, this.state.userId).then(
            (res) => {
              this.props.history.push("");
            }
           
          );}
          else{
            alert("Form is Invalid")
        }

       
    }
    changeCreatedByHandler = (event) => {
        this.setState({ createdBy: event.target.value });
      };
      changeModifiedByHandler = (event) => {
        this.setState({ modifiedBy: event.target.value });
      };

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

    formValChange = (e) => {
        e.preventDefault();
        const { name, value } = e.target;
        let isError = { ...this.state.isError };
        switch (name) {
            case "createdBy":
        isError.createdBy =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;
      case "modifiedBy":
        isError.modifiedBy =
          value.length < 5 ? "Atleast 5 characters required" : "";
        break;
          case "userId":
            isError.userId = regExp2.test(value) ? "" : "Numeric Values Required";
            break;
          case "name":
            isError.name = value.length < 5 ? "Atleast 5 characters required" : "";
            break;
          case "amount":
            isError.amount = regExp1.test(value) ? "" : "Amount  is Invalid";
            break;
    
          case "status":
            isError.status =
              value.length < 4 ? "Atleast 4 characters required" : "";
            break;
    
          default:
            break;
        }
        this.setState(
          {
            isError,
            [name]: value,
            disabled: false,
          },
          () => console.log(this.state)
        );
      };

    cancel(){
        this.props.history.push('/GuardSalary');

    }
    render() {
        const { isError } = this.state
        return (
            <div>
                <div className = "container">
                    <div className = "row">
                         <div className = "card col-md-6 offset-md-3 offset-md-3">
                             <h3 className ="text-center">Update Guard Details </h3>
                             <div className = "card-body">
                                 <form>
                                 <div className="form-group">
                  <label>Modified By</label>
                  <input
                    placeholder="modifiedBy"
                    name="modifiedBy"
                    className={
                      isError.modifiedBy.length > 0
                        ? "is-invalid form-control"
                        : "form-control"
                    }
                    value={this.state.modifiedBy}
                    noValidate
                    onChange={
                      (this.changeModifiedByHandler, this.formValChange)
                    }
                  />
                  {isError.modifiedBy.length > 0 && (
                    <span className="invalid-feedback">
                      {isError.modifiedBy}
                    </span>
                  )}
                </div>
                                     <div className = "form-group">
                                         <label>Name:</label>
                                         <input placeholder = "Name" name = "name" 
                                         className={ isError.name.length > 0
                                        ? "is-invalid form-control"
                                        : "form-control"
                    }
                                            value ={this.state.name} onChange={(this.changeNameHandler,this.formValChange)}/>
                                            {isError.name.length > 0 && (
                    <span className="invalid-feedback">{isError.name}</span>
                  )}
                                     </div>
                                     <div className = "form-group">
                                         <label>User ID:</label>
                                         <input placeholder = "User ID" name = "userId" 
                                         className= { isError.userId.length > 0
                                        ? "is-invalid form-control"
                                        : "form-control"
                    }
                                            value ={this.state.userId} onChange={(this.changeuserIDHandler,this.formValChange)}/>
                                            {isError.userId.length > 0 && (
                    <span className="invalid-feedback">{isError.userId}</span>
                  )}
                                     </div>
                                     <div className = "form-group">
                                         <label>Amount:</label>
                                         <input placeholder = "amount" name = "amount" 
                                         className={ isError.amount.length > 0
                                         ? "is-invalid form-control"
                                         : "form-control"
                    }
                                            value ={this.state.amount} onChange={(this.changeamountHandler,this.formValChange)}/>
                                            {isError.amount.length > 0 && (
                    <span className="invalid-feedback">{isError.amount}</span>
                  )}
                                     </div>
                                     <div className = "form-group">
                                         <label>Status:</label>
                                         <input placeholder = "status" name = "status" 
                                         className={isError.status.length > 0
                                        ? "is-invalid form-control"
                                        : "form-control"
                    }
                                            value ={this.state.status} onChange={(this.changestatusHandler,this.formValChange)}/>

                                            {isError.status.length > 0 && (
                    <span className="invalid-feedback">{isError.status}</span>
                  )}
                                     </div>
                                     <div className="form-group">
                                        <label>Date</label>
                                        <input
                                        placeholder="Date"
                                        name="date"
                                        className="form-control"
                                        value={today}
                                    
                                         onChange={this.changedateHandler}
                                             />
                                    </div>

                                     
                                     <button disabled={this.state.disabled}
                                     className= "btn btn-success" onClick={this.updateGuardSalary}>Save</button>

                                     <button 
                                     className= "btn btn-danger" onClick={this.cancel.bind(this)} style={{marginleft: "10px"}}>Cancel</button>
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