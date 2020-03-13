# MVVM

## 일반적인 앱 로직
1. Action Trigger (View, Alarm, Etc..)
2. Request(CRUD) - Model
3. Notify, Render (View)
- without MVVM
  - 1 -> 2 -> 3
- with MVVM
  - 1 -> 2
  - ViewModel - LiveData
  - 3
