
'use strict';

define(['app'], function (app) {

    var roleFilter = function () {

        return function (roles, filterValue) {
            if (!filterValue) return roles;
            var matches = [];
            filterValue = filterValue.toLowerCase();
            for (var i = 0; i < roles.length; i++) {
                var role = roles[i];
                if ((role.roleID != undefined && role.roleID.toLowerCase().indexOf(filterValue) > -1) ||
                    (role.name != undefined && role.name.toLowerCase().indexOf(filterValue) > -1)) {
                    matches.push(role);
                }
            }
            return matches;
        };
    };

    app.filter('roleFilter', roleFilter);

});