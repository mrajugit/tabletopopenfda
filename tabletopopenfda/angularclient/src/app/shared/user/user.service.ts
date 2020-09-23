import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) {
  }
   getAll(): Observable<any> {
    return this.http.get('//localhost:8080/users');
  }
   get(id: string) {
    return this.http.get('//localhost:8080/users' + '/' + id);
  }

  save(user: any): Observable<any> {
    let result: Observable<Object>;
    if (user['href']) {
      result = this.http.put('//localhost:8080/users' + '/' + user['href'], user);
    } else {
      result = this.http.post('//localhost:8080/users', user);
    }
    return result;
  }

   remove(href: string) {
    return this.http.delete('//localhost:8080/users' + '/' + href);
  }




}
