import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

import { debounceTime, tap, switchMap, finalize } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'starter app for tabletop';
  searchDrugsCtrl = new FormControl();
  filteredDrugs: any;
  isLoading = false;
  errorMsg: string;

  constructor(private http: HttpClient) {
   }

   ngOnInit() {
    this.searchDrugsCtrl.valueChanges
      .pipe(
        debounceTime(500),
        tap(() => {
          this.errorMsg = '';
          this.filteredDrugs = [];
          this.isLoading = true;
        }),
        switchMap(value => this.http.get("https://api.fda.gov/drug/label.json?count=openfda.brand_name.exact&limit=1000")
          .pipe(
            finalize(() => {
              this.isLoading = false
            }),
          )
        )
      )
      .subscribe(data => {
        if (data['Search'] == undefined) {
          this.errorMsg = data['Error'];
          this.filteredDrugs = [];
        } else {
          this.errorMsg = '';
          this.filteredDrugs = data['Search'];
        }
 
        console.log(this.filteredDrugs);
      });
  }
}
