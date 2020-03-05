import React from 'react';
import './App.css';


class IssueFilter extends React.Component{
  render() {
      return(
          <div>Place holder text for IssueFilter</div>
      );
  }
}

const IssueRow = (props) => {
  return(
      <tr>
      <td>{props.issue.id}</td>
      <td>{props.issue.status}</td>
      <td>{props.issue.owner}</td>
      <td>{props.issue.created.toDateString()}</td>
      <td>{props.issue.effort}</td>
      <td>{props.issue.completionDate ? props.issue.completionDate.toDateString() : ' '}</td>
      <td>{props.issue.title}</td>
  </tr>
  );
}


function IssueTable(props) {
  const issueRows = props.issues.map(issue => <IssueRow key={issue.id} issue={issue}/>)
      return(
          <table className="bordered-table">
              <thead>
                  <tr>
                      <th>Id</th>
                      <th>Status</th>
                      <th>Owner</th>
                      <th>Created</th>
                      <th>Effort</th>
                      <th>completion Date</th>
                      <th>Title</th>
                  </tr>
              </thead>
          <tbody>{issueRows}</tbody>
          </table>
      );
}

class IssueAdd extends React.Component{
  constructor() {
      super();
      this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleSubmit(e) {
      e.preventDefault();
      var form = document.forms.issueAdd;
      this.props.createIssue({
          owner : form.owner.value,
          title : form.title.value,
          status : 'New',
          created : new Date(),

      });
      form.owner.value="";
      form.title.value="";
  }

  
  render() {
      return(
          <div>
              <form name="issueAdd" onSubmit={this.handleSubmit}>
                  <input type="text" name="owner" placeholder="Owner"/>
                  <input type="text" name="title" placeholder="Title"/>
                  <button>Add</button>
              </form>
          </div>
      );
  }
}

class IssueList extends React.Component {
  constructor() {
      super();
      this.state = {issues : []};
      this.createIssue = this.createIssue.bind(this);
  }

  componentDidMount() {
      this.loadData();
  }

  loadData() {
      fetch('http://localhost:8080/issues')
      .then(response => response.json()).then(
          data => {
            data.forEach(issue => {
                console.log(issue);
                issue.created = new Date(issue.created);
                if(issue.completionDate) 
                  issue.completionDate = new Date(issue.completionDate);
            });
            this.setState({issues: data});  
          }
      ).catch(
          err => {console.log(err);}
      );
  }

  createIssue(newIssue) {
      fetch('http://localhost:8080/issues', {
          method: 'POST',
          headers: {'Content-Type': 'application/json'},
          body: JSON.stringify(newIssue),
      }).then(response => response.json()).then(
          updatedIssue => {
              updatedIssue.created = new Date(updatedIssue.created);
              if(updatedIssue.completionDate) 
                  updatedIssue.completionDate = new Date(updatedIssue.completionDate);
              const newIssues = this.state.issues.concat(updatedIssue);
              this.loadData();
          }
      ).catch(err => {
          console.log("Error in sending data to server: " + err.message);
      });
      let newIssues = this.state.issues.slice();
      newIssues.push(newIssue);
      this.setState({issues: newIssues});
  }

  render() {
      return (
          <div>
              <h1>Issue Tracker</h1>
              <IssueFilter/>
              <hr />
              <IssueTable issues={this.state.issues}/>
              <hr />
              <IssueAdd createIssue={this.createIssue}/>
              <hr/>
          </div>
      );
  }
}

function App() {
  return (
    <div className="App">
        <IssueList/>
    </div>
  );
}

export default App;
